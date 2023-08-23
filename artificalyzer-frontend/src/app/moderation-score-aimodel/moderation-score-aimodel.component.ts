import { Component } from '@angular/core';

@Component({
  selector: 'app-moderation-score-aimodel',
  templateUrl: './moderation-score-aimodel.component.html',
  styleUrls: ['./moderation-score-aimodel.component.scss']
})
export class ModerationScoreAimodelComponent {
  view: [number, number] = [700, 400];
  colorScheme: any;

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

  onSelect(event: any): void {
    console.log(event);
  }

  constructor() {
    this.colorScheme = {
      domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
    };
  }

  ngOnInit(): void {}
}
