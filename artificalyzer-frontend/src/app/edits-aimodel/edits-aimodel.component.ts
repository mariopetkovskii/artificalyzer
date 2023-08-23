import { Component } from '@angular/core';
import {ApiService} from "../api.service";
import {Router} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-edits-aimodel',
  templateUrl: './edits-aimodel.component.html',
  styleUrls: ['./edits-aimodel.component.scss']
})
export class EditsAimodelComponent {
  text: string = '';
  instruction: string = '';
  response: any;
  errorMessage: string = '';

  constructor(private apiService: ApiService, private router: Router,
              private location: Location) {
  }

  handleSubmit() {
    this.apiService.instructionModelEditsPost(this.text, this.instruction)
      .subscribe((data) => {
        this.response = data
      })
  }
}
