import {Component, OnInit} from '@angular/core';
import {ApiService} from "../api.service";
import {Router} from "@angular/router";
import {Location} from "@angular/common";
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recover-account',
  templateUrl: './recover-account.component.html',
  styleUrls: ['./recover-account.component.scss']
})
export class RecoverAccountComponent implements OnInit{
  password: string = '';
  confirmPassword: string = '';
  token: string | null = '';

  constructor(private apiService: ApiService, private router: Router,
              private location: Location,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.queryParamMap.subscribe(params => {
      this.token = params.get('token');
    });
  }

  handleSubmit() {
    this.apiService.changeRecoveryAccountPassword(this.password, this.confirmPassword, this.token).subscribe()
  }

}
