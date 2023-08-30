import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-my-moderation-score',
  templateUrl: './my-moderation-score.component.html',
  styleUrls: ['./my-moderation-score.component.scss']
})
export class MyModerationScoreComponent implements OnInit{

  
  myScores:any;
  view: [number, number] = [700, 400];

  colorScheme: any;
  prompt: any;

  chartData = [
    {
      name: 'Category A',
      value: 50
    },
    {
      name: 'Category B',
      value: 25
    },
    {
      name: 'Category C',
      value: 15
    },
    {
      name: 'Category D',
      value: 10
    }
  ];

  chartDataResponse=[];


  constructor(private apiService: ApiService){
    this.colorScheme = {
      domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA','#FFFFFF','#BBBBBB','#781C70']
    };
  }
  ngOnInit(): void {
    this.getMyScores()
  }

  onSelect(event: any): void {
    console.log(event);
  }
  getMyScores(){
    this.apiService.getMyScores(0).subscribe({
      next:((res:any)=>{
        this.myScores=res[0];

        this.chartData = [
          { name: 'Hate', value: this.myScores.moderation.hateScore },
          { name: 'Hate and Threatening', value: this.myScores.moderation.hateAndThreateningScore },
          { name: 'Self Harm', value: this.myScores.moderation.selfHarmScore },
          { name: 'Sexual Content', value: this.myScores.moderation.sexualScore },
          { name: 'Sexual Content Involving Minors', value: this.myScores.moderation.sexualMinorsScore },
          { name: 'Violence', value: this.myScores.moderation.violenceScore },
          { name: 'Violence (Graphic)', value: this.myScores.moderation.violenceGraphicScore }
        ];
        
      })
    })
  }
}
