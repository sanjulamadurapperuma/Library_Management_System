export class Book {
  constructor (
    public itemISBN: number,
    public itemTitle: string,
    public itemSector: string,
    public publicationDate: string,
    public author: string,
    public publisher: string,
    public numberOfPages: number
  ) {}
}
