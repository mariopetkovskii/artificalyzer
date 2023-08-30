import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-my-edits',
  templateUrl: './my-edits.component.html',
  styleUrls: ['./my-edits.component.scss']
})
export class MyEditsComponent implements OnInit{

  myEdits:any;

  constructor(private apiService: ApiService){

  }
  ngOnInit(): void {
    this.getMyEdits()
  }

  getMyEdits(){
    this.apiService.getMyEdits(0).subscribe({
      next:((res:any)=>{
        console.log(res);
        this.myEdits=res;
      })
    })
  }

}
