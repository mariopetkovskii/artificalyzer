from flask import Flask, request, jsonify
from textblob import TextBlob
import json
from translate import Translator

app = Flask(__name__)

def translate_sentence(sentence, target_lang):
    translator = Translator(to_lang=target_lang)
    translated = translator.translate(sentence)
    return translated

@app.route('/translate_sentences', methods=['POST'])
def translate_sentences():
    data = request.json
    lg = data['lg']
    english_sentence = data['sentence']
    print(english_sentence)
    print(lg)
    translated = translate_sentence(english_sentence, lg)
    my_dict = {"translated": translated}
    my_json = json.dumps(my_dict)
    return my_json


@app.route('/analysis', methods=['POST'])
def analysis():
    data = request.get_json()
    sentence = data['sentence']

    blob = TextBlob(sentence)
    polarity = blob.sentiment.polarity

    if polarity > 0:
        polarity_str = "Positive sentiment"
    elif polarity < 0:
        polarity_str = "Negative sentiment"
    else:
        polarity_str = "Neutral sentiment"

    my_dict = {"polarity": polarity_str}

    return jsonify(my_dict)


if __name__ == '__main__':
    app.run()
