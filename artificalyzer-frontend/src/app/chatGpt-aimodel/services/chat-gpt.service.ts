import { Injectable } from '@angular/core';
import axios from 'axios';


@Injectable({
  providedIn: 'root'
})
export class ChatService {
  apiEndpoint = 'https://api.openai.com/v1/chat/completions';
  apiKey = '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';

  constructor() { }

  async sendMessage(messages: string[]) {
    const requestData = {
      model: 'gpt-3.5-turbo',
      messages: messages.map(message => {
        return {
          role: 'user',
          content: message
        };
      })
    };

    return axios.post(this.apiEndpoint, requestData, {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.apiKey}`
      }
    }).then(response => {
      const completedMessage = response.data.choices[0].message.content;
      console.log(completedMessage)
      return completedMessage;
    });
  }
}