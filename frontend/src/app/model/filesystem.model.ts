
export class FileSystem {

  private avail: number;
  private percentUsed: number;

  constructor (
    private name?: string,
    private mountOn?: string,
    private total?: number,
    private used?: number
  ) {
    this.setUsed(used);
  }

  private setUsed(used: number) {
    this.used = used;
    this.avail = this.total - this.used;
    this.percentUsed = Math.round((this.used / this.total) * 100);
  }
}
