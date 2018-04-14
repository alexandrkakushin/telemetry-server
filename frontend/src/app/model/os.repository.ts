
import { Injectable } from "@angular/core";
import {Os} from "./os.model";
import {StaticDataSource} from "./static.datasource";

@Injectable()
export class OsRepository {

  private operatingSystem: Os;

  constructor(private dataSource: StaticDataSource) {
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
