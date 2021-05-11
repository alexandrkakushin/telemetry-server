
import { Injectable } from "@angular/core";
import { timer } from 'rxjs';
import { RestDataSource } from "./rest.datasource";
import { Cpu } from "../cpu.model";

@Injectable()
export class CpuRepository {

  private cpu: Cpu;

  constructor(private dataSource: RestDataSource) {
    timer(0, 3000)
      .subscribe(() => {
        this.dataSource.getCpu().subscribe(
          data => {
            this.cpu = Cpu.assign(data);
          }
        );
      });
  }

  getCpu(): Cpu {
    return this.cpu;
  }
}
