import { Component } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-my-images',
  templateUrl: './my-images.component.html',
  styleUrls: ['./my-images.component.scss']
})
export class MyImagesComponent {

  
  myImages:any;

  constructor(private apiService: ApiService){

  }
  ngOnInit(): void {
    this.getMyImages()
  }

  getMyImages(){
    this.apiService.getMyImages(0).subscribe({
      next:((res:any)=>{
        console.log(res);
        this.myImages=res;
      })
    })
  }
}
