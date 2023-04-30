from flask import Flask, request
import json

app = Flask(__name__)

@app.route('/compare_sentences', methods=['POST'])
def compare_sentences():
    data = request.json
    lg = data['lg']
    from transformers import MarianMTModel, MarianTokenizer

    model_name = 'Helsinki-NLP/opus-mt-en-'+lg
    model = MarianMTModel.from_pretrained(model_name)
    tokenizer = MarianTokenizer.from_pretrained(model_name)
    english_sentence = data['sentence1']
    input_ids = tokenizer.encode(english_sentence, return_tensors='pt')
    output_ids = model.generate(input_ids)
    translated_sentence = tokenizer.decode(output_ids[0], skip_special_tokens=True)
    my_dict = {"translated": translated_sentence}
    my_json = json.dumps(my_dict)
    return my_json


if __name__ == '__main__':
    app.run()
