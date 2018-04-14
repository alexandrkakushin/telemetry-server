
import { NgModule } from "@angular/core";
import { StaticDataSource } from "./static.datasource";
import { HttpModule } from "@angular/http";
import {OsRepository} from "./os.repository";
import {FileSystemsRepository} from "./filesystems.repository";
import {SensorsRepository} from "./sensors.repository";
import {RestDataSource} from "./rest.datasource";

@NgModule({
  imports: [HttpModule],
  providers: [
    FileSystemsRepository,
    SensorsRepository,
    OsRepository,
    //StaticDataSource
    {provide: StaticDataSource, useClass: RestDataSource}
    ]
})

export class ModelModule {}
