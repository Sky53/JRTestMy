function Component(param: { selector: string; templateUrl: string }) {

}

@Component({
    selector: 'ngbd-pagination-basic',
    templateUrl: './pagination-basic.html'
})
export class NgbdPaginationBasic {
    page = 4;
}