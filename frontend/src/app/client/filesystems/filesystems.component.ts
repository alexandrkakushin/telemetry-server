import { Component } from '@angular/core';
import {FileSystem} from "../../model/filesystem.model";
import {FileSystemsRepository} from "../../model/repository/filesystems.repository";

@Component({
  selector: 'filesystems-root',
  moduleId: module.id,
  templateUrl: './filesystems.component.html'
})
export class FileSystemsComponent {

  constructor(private repository: FileSystemsRepository) {}

  get fileSystems(): FileSystem[] {
    return this.repository.getFileSystems();
  }
}
