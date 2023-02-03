function refindText(source, options) {
  //변수 rename fn+F2
  //리팩토링 cntl+shift+R
  return [normalizeWhiteSpaces, compactWhiteSpaces, maskBannedWords].reduce(
    (value, filter) => filter(value, options),
    source
  );
}

const compactWhiteSpaces = (source) => {
  return source.indexOf("  ") < 0
    ? source
    : compactWhiteSpaces(source.replace("  ", " "));
};

function normalizeWhiteSpaces(source) {
  source = source.replace("/t", " ");
  return source;
}

function maskBannedWords(source, options) {
  if (options) {
    for (const bannedWord of options.bannedWords) {
      source = maskBannedWord(source, bannedWord);
    }
  }
  return source;
}

function maskBannedWord(source, bannedWord) {
  return source.replace(bannedWord, "*".repeat(bannedWord.length));
}

module.exports = refindText;
