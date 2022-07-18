import {Component, OnInit} from '@angular/core';
import {ErsRequestService} from '../ers-request.service';
import {AuthService} from "../auth.service";

@Component({
  selector: 'app-ers-request-list',
  templateUrl: './ers-request-list.component.html',
  styleUrls: ['./ers-request-list.component.css']
})
export class ErsRequestListComponent implements OnInit {

  requests: Array<any> = []
  isManager = false

  constructor(
    private ersRequestService: ErsRequestService,
    private authService: AuthService
  ) {
  }

  ngOnInit(): void {
    this.authService.userDetails.roles?.forEach((role: any) => {
      if (role.name === "MANAGER") {
        this.isManager = true;
        console.log(this.isManager)
      }
    })
    this.ersRequestService.getRequests()
      .subscribe((requests: any) => {
        this.requests = requests
      })
  }

  handleStatus(requestId: number, status: string) {
    this.ersRequestService.updateRequest(requestId, status)
      .subscribe({
        next: () => {
          let req = this.requests.find(request => request.id === requestId);
          req.status = status
        }
      })
  }

}
