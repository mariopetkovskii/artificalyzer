import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-translate-sentence',
  templateUrl: './translate-sentence.component.html',
  styleUrls: ['./translate-sentence.component.scss']
})
export class TranslateSentenceComponent {

  sentence: string = '';
  selectedLanguage: string = '';
  response: string = '';

  constructor(private http: HttpClient) {}
  isError: boolean = false;

  submitForm() {
    const endpoint = 'http://localhost:10101/rest/model/sentence/translate_sentence';
    const requestData = { sentence: this.sentence, lg: this.selectedLanguage };

    this.http.post(endpoint, requestData).subscribe(
      (data: any) => {
        this.response = data.translated;
        this.isError = true;
        console.log(this.response)
      },
      (error) => {
        this.response = 'Error: ' + error.message;
        this.isError = true;
      }
    );
  }
}
