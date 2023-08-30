import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-my-edits',
  templateUrl: './my-edits.component.html',
  styleUrls: ['./my-edits.component.scss']
})
export class MyEditsComponent implements OnInit{

  myEdits:any;
  totalItems: any;
  pageSize: number = 10;
  currentPage: number = 1;


  constructor(private apiService: ApiService){

  }
  ngOnInit(): void {
    this.getMyEdits()
  }

  handlePageChange(newPageIndex: number) {
    this.currentPage = newPageIndex;
    this.getMyEdits();
  }

  getMyEdits(){
    this.apiService.getMyEdits(this.pageSize, this.currentPage-1).subscribe({
      next:((res:any)=>{
        console.log(res);
        this.myEdits=res;
        this.totalItems = res.totalElements
      })
    })
  }

}
