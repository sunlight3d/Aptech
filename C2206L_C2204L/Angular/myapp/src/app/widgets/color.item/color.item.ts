import { Component, Input } from '@angular/core';

@Component({
  selector: 'color-item',
  templateUrl: './color.item.html',
  styleUrls: ['./color.item.scss']
})
export class ColorItem {
  @Input() color: string = '#3498db'; // Default color
  @Input() isSelected: boolean = false; //props in ReactJS
}
