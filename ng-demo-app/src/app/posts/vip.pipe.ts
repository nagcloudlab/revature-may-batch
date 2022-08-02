import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'vip'
})
export class VipPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {
    return value.startsWith("VI");
  }

}
