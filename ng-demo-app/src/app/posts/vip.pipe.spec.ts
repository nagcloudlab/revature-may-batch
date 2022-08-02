import { VipPipe } from './vip.pipe';

describe('VipPipe', () => {

  it('create an instance', () => {
    const pipe = new VipPipe();
    expect(pipe).toBeTruthy();
  });

  it('should be vip post', () => {
    const pipe = new VipPipe();
    expect(pipe.transform("VIP")).toBeTruthy();
  });


});
