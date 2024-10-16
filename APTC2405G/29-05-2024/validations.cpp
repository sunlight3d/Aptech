bool isInvalidPrice(int price) {
    return price < 500 || price > 6000;
}
bool isInvalidReleaseYear(int released_year) {
    return released_year < 1999;
}