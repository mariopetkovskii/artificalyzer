import { Component } from '@angular/core';
import { ChatService } from '../../services/chat-gpt.service';
import { IChat } from '../../models/chat';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';

@Component({
  selector: 'app-chat-gpt',
  templateUrl: './chat-gpt.component.html',
  styleUrls: ['./chat-gpt.component.scss']
})
export class ChatGptComponent {
  userInput!: string;
  botMessage!: string;
  userInputs: string[] = [];
  chats: IChat[] = [];

  constructor(private chatService: ChatService, private sanitizer: DomSanitizer) { }

  sendRequest() {
    this.userInputs.push(this.userInput);
    this.chatService.sendMessage(this.userInputs).then(completedMessage => {
      this.botMessage = completedMessage;
      this.chats.push({chatInput: this.userInput, chatOutput: completedMessage})
      this.userInput = '';
    }).catch(error => {
      console.error(error);
    });
  }

  getSafeHtml(value: string): SafeHtml {
    let html = value.replace(/\n/g, '<br>');
    const codeBlocks = html.split('```');
    html = codeBlocks.map((block, index) => {
    if (index % 2 === 1) {
    return `<code>${block}</code>`;
    } else {
    return block;
    }
    }).join('');
    return this.sanitizer.bypassSecurityTrustHtml(html);
    }

}
