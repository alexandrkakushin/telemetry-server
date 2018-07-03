
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { ModelModule } from "../model/model.module";
import { OsComponent } from "./os/os.component";
import { FileSystemsComponent } from "./filesystems/filesystems.component";
import { SensorsComponent } from "./sensors/sensors.component";

@NgModule({
  imports: [ModelModule, BrowserModule],
  declarations: [OsComponent, FileSystemsComponent, SensorsComponent],
  exports: [OsComponent, FileSystemsComponent, SensorsComponent]
})

export class ClientModule {}
