from flask import Flask, request, jsonify
from textblob import TextBlob
import json

app = Flask(__name__)

@app.route('/translate_sentences', methods=['POST'])
def translate_sentences():
    data = request.json
    print(data)
    lg = data['lg']
    english_sentence = data['sentence']
    print(english_sentence)
    print(lg)
    from transformers import AutoTokenizer, AutoModelForSeq2SeqLM
    model_name = "Helsinki-NLP/opus-mt-en-"+str(lg)
    print(model_name)
    tokenizer = AutoTokenizer.from_pretrained(model_name)
    model = AutoModelForSeq2SeqLM.from_pretrained(model_name)
    input_ids = tokenizer.encode(english_sentence, return_tensors="pt")
    outputs = model.generate(input_ids=input_ids, max_length=128, num_beams=4, early_stopping=True)
    decoded_outputs = tokenizer.decode(outputs[0], skip_special_tokens=True)
    print(decoded_outputs)
    my_dict = {"translated": decoded_outputs}
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
