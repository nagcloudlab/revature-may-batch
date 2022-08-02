import {HttpClientModule} from '@angular/common/http';
import {TestBed} from '@angular/core/testing';
import {LogService} from './log.service';

import {PostsService} from './posts.service';

// suite
// test-cases-1
// test-cases-2

describe('PostsService', () => {

  let postsService: PostsService;
  let logServiceSpy: LogService;

  beforeEach(() => {
    logServiceSpy = jasmine.createSpyObj('LogService', ['log']);
    TestBed.configureTestingModule({
      imports: [
        HttpClientModule
      ],
      providers: [
        PostsService,
        {provide: LogService, useValue: logServiceSpy}
      ]
    });
    postsService = TestBed.inject(PostsService);
  });

  it('should be 3 posts count', () => {
    let actual = postsService.getCount()
    expect(actual).toEqual(3)
    expect(logServiceSpy.log).toHaveBeenCalledTimes(1)
  });

  it("should fetch top 5 posts", (done) => {
    postsService.getPosts()
      .subscribe({
        next: ((response: any) => {
          expect(response.length).toEqual(5)
          done()
        }),
        error: (err: any) => {
          done.fail("error while fetching posts")
        }
      })
  })


});
