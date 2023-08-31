import {Component, OnInit} from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-mytranslate-sentences',
  templateUrl: './mytranslate-sentences.component.html',
  styleUrls: ['./mytranslate-sentences.component.scss']
})
export class MytranslateSentencesComponent implements OnInit{
  myTranslatedSentences:any;
  totalItems: any;
  pageSize: number = 10;
  currentPage: number = 1;

  constructor(private apiService: ApiService){

  }
  ngOnInit(): void {
    this.getmyTranslatedSentences()
  }
  handlePageChange(newPageIndex: number) {
    this.currentPage = newPageIndex;
    this.getmyTranslatedSentences();
  }

  getmyTranslatedSentences(){
    this.apiService.getmyTranslatedSentences(this.pageSize, this.currentPage - 1).subscribe({
      next:((res:any)=>{
        console.log(res);
        this.myTranslatedSentences=res;
        console.log(this.myTranslatedSentences)
        this.totalItems = res.totalElements
      })
    })
  }
}
