import {ComponentFixture, TestBed} from '@angular/core/testing';

import {CounterComponent} from './counter.component';

describe('CounterComponent', () => {
  let component: CounterComponent;
  let fixture: ComponentFixture<CounterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CounterComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(CounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should contain zero as intial count', () => {
    expect(component.count).toBe(0);
  });


  it('should should increment count', () => {
    let button = fixture.debugElement.nativeElement.querySelector('#b1');
    button.click();
    // fixture.whenStable().then(() => {
    expect(component.count).toBe(1);
    // });
  });


});
