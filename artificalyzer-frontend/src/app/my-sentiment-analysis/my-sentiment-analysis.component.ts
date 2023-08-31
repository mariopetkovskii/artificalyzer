import {Component, OnInit} from '@angular/core';
import { ApiService } from '../api.service';
@Component({
  selector: 'app-my-sentiment-analysis',
  templateUrl: './my-sentiment-analysis.component.html',
  styleUrls: ['./my-sentiment-analysis.component.scss']
})
export class MySentimentAnalysisComponent implements OnInit{
  mySentimentAnalysis:any;
  totalItems: any;
  pageSize: number = 10;
  currentPage: number = 1;

  constructor(private apiService: ApiService){

  }
  ngOnInit(): void {
    this.getmySentimentAnalysis()
  }
  handlePageChange(newPageIndex: number) {
    this.currentPage = newPageIndex;
    this.getmySentimentAnalysis();
  }

  getmySentimentAnalysis(){
    this.apiService.getmySentimentAnalysis(this.pageSize, this.currentPage - 1).subscribe({
      next:((res:any)=>{
        console.log(res);
        this.mySentimentAnalysis=res;
        console.log(this.mySentimentAnalysis)
        this.totalItems = res.totalElements
      })
    })
  }
}
