/*
    This example shows how to use the MITIE C++ API to perform named entity
    recognition. 
*/

#include <mitie/total_word_feature_extractor.h>
#include <mitie/conll_tokenizer.h>
#include <mitie/micro_ner.h>
#include <iostream>
#include <iomanip>
#include <fstream>
#include <cstdlib>

using namespace std;
using namespace mitie;

// ----------------------------------------------------------------------------------------

vector<string> tokenize_file (
    const string& filename
)
{
    ifstream fin(filename.c_str());
    if (!fin)
    {
        cout << "Unable to load input text file" << endl;
        exit(EXIT_FAILURE);
    }
    // The conll_tokenizer splits the contents of an istream into a bunch of words and is
    // MITIE's default tokenization method. 
    conll_tokenizer tok(fin);
    vector<string> tokens;
    string token;
    // Read the tokens out of the file one at a time and store into tokens.
    while(tok(token))
        tokens.push_back(token);

    return tokens;
}

// ----------------------------------------------------------------------------------------

int main(int argc, char** argv)
{
    try
    {
        mitie::micro_ner microNer("/Users/wihoho/Downloads/newModel-1.dat");
        microNer.reset_tag_name_strings("newCompanyName");

        dlib::serialize("newModel-1.dat")
        << "mitie::named_entity_extractor_pure_model"
        << microNer.get_df()
        << microNer.get_segmenter()
        << microNer.get_tag_name_strings();

        return EXIT_SUCCESS;
    }
    catch (std::exception& e)
    {
        cout << e.what() << endl;
        return EXIT_FAILURE;
    }
}

// ----------------------------------------------------------------------------------------

