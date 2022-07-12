import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {


  @Input()
  appHighlight = ''


  @Input()
  defaultColor = ''


  constructor(private el: ElementRef) {
    // console.log("HighlightDirective::constructor")
    // console.log(this.el)
    //this.el.nativeElement.style.backgroundColor = 'yellow'
  }

  @HostListener('mouseenter')
  onMouseEnter() {
    this.highlight(this.appHighlight || this.defaultColor || 'red');
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.highlight('')
  }

  private highlight(color: string) {
    this.el.nativeElement.style.backgroundColor = color;
  }

}
