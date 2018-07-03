import { Component } from '@angular/core';
import {OsRepository} from "../../model/os.repository";
import {Os} from "../../model/os.model";

@Component({
  selector: 'os-root',
  moduleId: module.id,
  templateUrl: './os.component.html'
})
export class OsComponent {

  constructor(private repository: OsRepository) {}

  get os(): Os {
    return this.repository.getOs();
  }
}
