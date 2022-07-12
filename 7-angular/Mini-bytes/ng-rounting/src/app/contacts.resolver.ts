import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { ContactsService } from './contacts.service';

@Injectable({
  providedIn: 'root'
})
export class ContactsResolver implements Resolve<boolean> {

  constructor(
    private contactsService: ContactsService
  ){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> {
    return this.contactsService.getContacts()
  }

}
