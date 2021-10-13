import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-switch-btn',
  templateUrl: './switch-btn.component.html',
  styleUrls: ['./switch-btn.component.css'],
})
export class SwitchBtnComponent implements OnInit {
  @Input() text!: string;
  @Input() color!: string;

  @Output() btnClick = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  onClick(): void {
    this.btnClick.emit(); // Emit the event
  }
}
