/*
    This example shows how to use the MITIE C++ API to perform named entity
    recognition. 
*/

#include <mitie/named_entity_extractor.h>
#include <mitie/conll_tokenizer.h>
#include <mitie/micro_ner.h>

using namespace std;
using namespace mitie;
// ----------------------------------------------------------------------------------------

std::vector<string> tokenize_file(
        const string &filename
) {
    ifstream fin(filename.c_str());
    if (!fin) {
        cout << "Unable to load input text file" << endl;
        exit(EXIT_FAILURE);
    }
    // The conll_tokenizer splits the contents of an istream into a bunch of words and is
    // MITIE"s default tokenization method. 
    conll_tokenizer tok(fin);
    std::vector<string> tokens;
    string token;
    // Read the tokens out of the file one at a time and store into tokens.
    while (tok(token))
        tokens.push_back(token);

    return tokens;
}

// ----------------------------------------------------------------------------------------

int main(int argc, char **argv) {
    try {
        std::map<std::string, std::string> myMap;

        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-birthDate.dat"] = "birthDate";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-career#company.dat"] = "applicantEntity.applicantInfo.career#company";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-career#department.dat"] = "applicantEntity.applicantInfo.career#department";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-career#eDate.dat"] = "applicantEntity.applicantInfo.career#eDate";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-career#position.dat"] = "applicantEntity.applicantInfo.career#position";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-career#sDate.dat"] = "applicantEntity.applicantInfo.career#sDate";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-education#degree.dat"] = "applicantEntity.applicantInfo.education#degree";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-education#eDate.dat"] = "applicantEntity.applicantInfo.education#eDate";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-education#education-department.dat"] = "applicantEntity.applicantInfo.education#education-department";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-education#gpa.dat"] = "applicantEntity.applicantInfo.education#gpa";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-education#school.dat"] = "applicantEntity.applicantInfo.education#school";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-education#sDate.dat"] = "applicantEntity.applicantInfo.education#sDate";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-email.dat"] = "email";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-gender.dat"] = "gender";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-languages#level.dat"] = "applicantEntity.applicantInfo.languages#level";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-languages#name.dat"] = "applicantEntity.applicantInfo.languages#name";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-mobile.dat"] = "mobile";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-publications#publicationDate.dat"] = "applicantEntity.applicantInfo.publications#publicationDate";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-publications#title.dat"] = "applicantEntity.applicantInfo.publications#title";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-skills#level.dat"] = "applicantEntity.applicantInfo.skills#level";
        myMap["F:\\hue-magic-core\\hue-magic-core-logic\\src\\main\\resources\\nerModels\\resume\\model-skills#name.dat"] = "applicantEntity.applicantInfo.skills#name";


        for (std::map<std::string, std::string>::const_iterator it = myMap.begin(); it != myMap.end(); ++it) {
            string modelPath = it->first;
            string newKey = it->second;

            mitie::micro_ner microNer(modelPath);
            microNer.reset_tag_name_strings(newKey);

            dlib::serialize(newKey + ".dat")
            << "mitie::named_entity_extractor_pure_model"
            << microNer.get_df()
            << microNer.get_segmenter()
            << microNer.get_tag_name_strings();
        }


        return EXIT_SUCCESS;
    }
    catch (std::exception &e) {
        cout << e.what() << endl;
        return EXIT_FAILURE;
    }
}

// ----------------------------------------------------------------------------------------

