import { Component } from '@angular/core';
import {FileSystem} from "../../model/filesystem.model";
import {FileSystemsRepository} from "../../model/repository/filesystems.repository";

@Component({
  selector: 'filesystems-detail',
  templateUrl: './filesystems-detail.component.html'
})
export class FileSystemsDetailComponent {

  constructor(private repository: FileSystemsRepository) {}

  get fileSystems(): FileSystem[] {
    return this.repository.getFileSystems();
  }
}
