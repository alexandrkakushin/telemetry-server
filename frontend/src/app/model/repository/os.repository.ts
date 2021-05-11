import { Injectable } from "@angular/core";
import { Os } from "../os.model";
import { RestDataSource } from "./rest.datasource";

@Injectable()
export class OsRepository {

  private os: Os = new Os(null, null, null);

  constructor(private dataSource: RestDataSource) {
    this.dataSource.getOs().subscribe(
      data => {
        this.os = Os.assign(data);
      }
    );
  }

  getOs(): Os {
    return this.os;
  }
}