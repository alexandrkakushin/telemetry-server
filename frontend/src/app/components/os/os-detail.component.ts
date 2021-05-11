import { Component } from '@angular/core';
import { OsRepository } from "../../model/repository/os.repository";
import { Os } from "../../model/os.model";

@Component({
  selector: 'os-detail',
  templateUrl: './os-detail.component.html'
})
export class OsDetailComponent {

  constructor(private repository: OsRepository) {}

  get os(): Os {
    return this.repository.getOs();
  }
}
