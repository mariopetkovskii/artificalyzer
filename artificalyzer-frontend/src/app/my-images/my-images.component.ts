import {Component, OnInit} from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-my-images',
  templateUrl: './my-images.component.html',
  styleUrls: ['./my-images.component.scss']
})
export class MyImagesComponent implements OnInit{
  myImages:any;
  totalItems: any;
  pageSize: number = 10;
  currentPage: number = 1;

  constructor(private apiService: ApiService){

  }
  ngOnInit(): void {
    this.getMyImages()
  }
  handlePageChange(newPageIndex: number) {
    this.currentPage = newPageIndex;
    this.getMyImages();
  }

  getMyImages(){
    this.apiService.getMyImages(this.pageSize, this.currentPage - 1).subscribe({
      next:((res:any)=>{
        console.log(res);
        this.myImages=res;
        this.totalItems = res.totalElements
      })
    })
  }
}
