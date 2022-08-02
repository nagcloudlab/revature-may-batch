import {ComponentFixture, TestBed} from '@angular/core/testing';

import {PostComponent} from './post.component';

describe('PostComponent', () => {

  let component: PostComponent;
  let fixture: ComponentFixture<PostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PostComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(PostComponent);
    component = fixture.componentInstance;
    component.post = {
      id: 1,
      title: "Angular",
      body: "i hate Unit Testing"
    }
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render post', () => {
    expect(fixture.nativeElement.querySelector('.display-2').textContent).toEqual("Angular")
    expect(fixture.nativeElement.querySelector('.display-3').textContent).toEqual("i hate Unit Testing")
  });


});
