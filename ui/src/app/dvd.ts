export class DVD {
  constructor (
    public itemISBN: number,
    public itemTitle: string,
    public itemSector: string,
    public publicationDate: string,
    public languages: string,
    public subtitles: string,
    public producer: string,
    public actors: string
  ) {}
}
