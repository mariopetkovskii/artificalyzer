import { Component } from '@angular/core';
import {ApiService} from "../api.service";
import {Router} from "@angular/router";
import {Location} from "@angular/common";
import {parseJson} from "@angular/cli/src/utilities/json-file";

@Component({
  selector: 'app-sentence-statements',
  templateUrl: './sentence-statements.component.html',
  styleUrls: ['./sentence-statements.component.scss']
})
export class SentenceStatementsComponent {
  sentence: string = '';
  response: any;
  errorMessage: string = '';

  constructor(private apiService: ApiService, private router: Router,
              private location: Location) {
  }

  handleSubmit() {
    this.apiService.analyzeSentence(this.sentence)
      .subscribe((data) => {
        this.response = data
      })
  }
}
