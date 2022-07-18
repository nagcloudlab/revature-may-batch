import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ErsRequestService {

  api = "http://localhost:8181/api/reimbursements"

  constructor(
    private httpClient: HttpClient
  ) {
  }

  submitNewRequest(requestForm: any) {
    return this.httpClient.post(this.api, requestForm)
  }

  getRequests() {
    return this.httpClient.get(this.api)
  }

  updateRequest(requestId: number, status: string) {
    return this.httpClient.patch(this.api, {
      id: requestId,
      status: status
    })
  }

}
