import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css'],
})
export class MessageComponent implements OnInit {
  @Input() isSender!: boolean;
  @Input() message!: string;
  @Input() timestamp!: string;

  constructor() {}

  ngOnInit(): void {}
}
