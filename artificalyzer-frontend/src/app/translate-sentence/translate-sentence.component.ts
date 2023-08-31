import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {ApiService} from "../api.service";

@Component({
  selector: 'app-translate-sentence',
  templateUrl: './translate-sentence.component.html',
  styleUrls: ['./translate-sentence.component.scss']
})
export class TranslateSentenceComponent {

  sentence: string = '';
  selectedLanguage: string = '';
  response: string = '';

  constructor(private apiService: ApiService) {}
  isError: boolean = false;

  submitForm() {
    this.apiService.translateSentence(this.sentence, this.selectedLanguage)
      .subscribe((data: any) => {
          this.response = data.translated;
          console.log(this.response)
        },
        (error) => {
          this.response = 'Error: ' + error.message;
          this.isError = true;
        }
      );
  }
}
