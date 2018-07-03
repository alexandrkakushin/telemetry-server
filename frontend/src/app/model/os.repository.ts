
import { Injectable } from "@angular/core";
import {Os} from "./os.model";
import {RestDataSource} from "./rest.datasource";

@Injectable()
export class OsRepository {

  private operatingSystem: Os;

  constructor(private dataSource: RestDataSource) {
    this.dataSource.getOs().subscribe(
      data => {
        this.operatingSystem = data;
      }
    );
  }

  getOs(): Os {
    return this.operatingSystem;
  }
}
