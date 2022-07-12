import {Injectable} from '@angular/core';
import { from, of } from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ContactsService {

  contacts:Array<any>=[
    {id:1,name: "Nag", email: "Nag@gmail.com", mobile: "1234567890",address:'India'},
    {id:2,name: "Tom", email: "Tom@gmail.com", mobile: "1234567890",address:'US'},
    {id:3,name: "Bob", email: "Bob@gmail.com", mobile: "12345",address: 'Universe'}
  ]

  constructor() {
  }

  getContacts() {
    return of(this.contacts).pipe(delay(100))
  }

  getContactDetails(cId:number){
    return this.contacts.find(c=>c.id===cId)
  }

}
