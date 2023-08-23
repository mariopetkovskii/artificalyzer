import { Component } from '@angular/core';
import {ApiService} from "../api.service";
import {Router} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-image-aimodel',
  templateUrl: './image-aimodel.component.html',
  styleUrls: ['./image-aimodel.component.scss']
})
export class ImageAimodelComponent {
  prompt: string = '';
  size: string = '';
  response: any;
  errorMessage: string = '';

  constructor(private apiService: ApiService, private router: Router,
              private location: Location) {
    this.size = '512x512'
  }

  handleSubmit() {
    this.apiService.generateImage(this.prompt, this.size)
      .subscribe((data) => {
        this.response = data
      })
  }

}
