import { Component } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-moderation-score-aimodel',
  templateUrl: './moderation-score-aimodel.component.html',
  styleUrls: ['./moderation-score-aimodel.component.scss']
})
export class ModerationScoreAimodelComponent {
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

  onSelect(event: any): void {
    console.log(event);
  }

  constructor(private apiService: ApiService) {
    this.colorScheme = {
      domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA','#FFFFFF','#BBBBBB','#781C70']
    };
  }

  ngOnInit(): void {
  }

  handleSubmit() {
    this.apiService.getModerationScore(this.prompt).subscribe({
      next: (response: any) => {
        this.chartData = [
          { name: 'Hate', value: response.hateScore },
          { name: 'Hate and Threatening', value: response.hateAndThreateningScore },
          { name: 'Self Harm', value: response.selfHarmScore },
          { name: 'Sexual Content', value: response.sexualScore },
          { name: 'Sexual Content Involving Minors', value: response.sexualMinorsScore },
          { name: 'Violence', value: response.violenceScore },
          { name: 'Violence (Graphic)', value: response.violenceGraphicScore }
        ];
      },
    })
  }
}

