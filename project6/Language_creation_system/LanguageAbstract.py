from abc import ABC, abstractmethod

"""
This module defines the abstarct superclass of Language, i.e. the abstract Product class in the Factory pattern.  
"""

class Language(ABC):

    def __init__(self, languagename):
        self.name = languagename
        self.vowels = set()
        self.consonants = set()
        self.rules = set()
        self.vowelDict = {'ɐ': 'soundEdited/vowels/near-open_central.wav',
                     'ɜ': 'soundEdited/vowels/open-mid_central_unrounded.wav',
                     'ʉ': 'soundEdited/vowels/close_central_rounded.wav',
                     'ɵ': 'soundEdited/vowels/close-mid_central_rounded.wav',
                     'o': 'soundEdited/vowels/close-mid_back_rounded.wav',
                     'ɤ': 'soundEdited/vowels/close-mid_back_unrounded.wav',
                     'y': 'soundEdited/vowels/close_front_rounded.wav',
                     'ø': 'soundEdited/vowels/close-mid_front_rounded.wav',
                     'e': 'soundEdited/vowels/close-mid_front_unrounded.wav',
                     'a': 'soundEdited/vowels/open_front_unrounded.wav', 'ə': 'soundEdited/vowels/mid-central.wav',
                     'ʌ': 'soundEdited/vowels/open-mid_back_unrounded.wav',
                     'æ': 'soundEdited/vowels/near-open_front_unrounded.wav',
                     'ʊ': 'soundEdited/vowels/near-close_near-back_rounded.wav',
                     'ɶ': 'soundEdited/vowels/open_front_rounded.wav',
                     'œ': 'soundEdited/vowels/open-mid_front_rounded.wav',
                     'i': 'soundEdited/vowels/close_front_unrounded.wav',
                     'ɔ': 'soundEdited/vowels/open-mid_back_rounded.wav',
                     'ɪ': 'soundEdited/vowels/near-close_near-front_unrounded.wav',
                     'ɞ': 'soundEdited/vowels/open-mid_central_rounded.wav',
                     'ʏ': 'soundEdited/vowels/near-close_near-front_rounded.wav',
                     'ɑ': 'soundEdited/vowels/open_back_unrounded.wav',
                     'ɘ': 'soundEdited/vowels/close-mid_central_unrounded.wav',
                     'ɨ': 'soundEdited/vowels/close_central_unrounded.wav',
                     'ɛ': 'soundEdited/vowels/open-mid_front_unrounded.wav',
                     'ɯ': 'soundEdited/vowels/close_back_unrounded.wav',
                     'u': 'soundEdited/vowels/close_back_rounded.wav', 'ɒ': 'soundEdited/vowels/open_back_rounded.wav'}

        self.pulmonicDict = {'ʐ': 'soundEdited/consonants/pulmonics/V_retroflex_fricative.wav',
                        'c': 'soundEdited/consonants/pulmonics/VL_palatal_plosive.wav',
                        'ħ': 'soundEdited/consonants/pulmonics/VL_pharyngeal_fricative.wav',
                        'ɴ': 'soundEdited/consonants/pulmonics/V_uvular_nasal.wav',
                        'ʟ': 'soundEdited/consonants/pulmonics/V_velar_lateral-approximant.wav',
                        'ʀ': 'soundEdited/consonants/pulmonics/V_uvular_trill.wav',
                        'k': 'soundEdited/consonants/pulmonics/VL_velar_plosive.wav',
                        'ʃ': 'soundEdited/consonants/pulmonics/VL_postalveolar_fricative.wav',
                        'ʎ': 'soundEdited/consonants/pulmonics/V_palatal_lateral-approximant.wav',
                        'ɢ': 'soundEdited/consonants/pulmonics/V_uvular_plosive.wav',
                        'ʔ': 'soundEdited/consonants/pulmonics/VL_glottal_plosive.wav',
                        'ʂ': 'soundEdited/consonants/pulmonics/VL_retroflex_fricative.wav',
                        'ʙ': 'soundEdited/consonants/pulmonics/V_bilabial_trill.wav',
                        'm': 'soundEdited/consonants/pulmonics/V_bilabial_nasal.wav',
                        'ɮ': 'soundEdited/consonants/pulmonics/V_alveolar_lateral-fricative.wav',
                        'ɦ': 'soundEdited/consonants/pulmonics/V_glottal_fricative.wav',
                        'ɣ': 'soundEdited/consonants/pulmonics/V_velar_fricative.wav',
                        'w': 'soundEdited/consonants/pulmonics/V_labial-velar_approximant.wav',
                        'ʝ': 'soundEdited/consonants/pulmonics/V_palatal_fricative.wav',
                        'ʕ': 'soundEdited/consonants/pulmonics/V_pharyngeal_fricative.wav',
                        't': 'soundEdited/consonants/pulmonics/VL_alveolar_plosive.wav',
                        'b': 'soundEdited/consonants/pulmonics/V_bilabial_plosive.wav',
                        'ʁ': 'soundEdited/consonants/pulmonics/V_uvular_fricative.wav',
                        'ɬ': 'soundEdited/consonants/pulmonics/VL_alveolar_lateral-fricative.wav',
                        'ɖ': 'soundEdited/consonants/pulmonics/V_retroflex_plosive.wav',
                        'ɡ': 'soundEdited/consonants/pulmonics/V_velar_plosive.wav',
                        'θ': 'soundEdited/consonants/pulmonics/VL_dental_fricative.wav',
                        'h': 'soundEdited/consonants/pulmonics/VL_glottal_fricative.wav',
                        'd': 'soundEdited/consonants/pulmonics/V_alveolar_plosive.wav',
                        'ɳ': 'soundEdited/consonants/pulmonics/V_retroflex_nasal.wav',
                        'ɰ': 'soundEdited/consonants/pulmonics/V_velar_approximant.wav',
                        'ɾ': 'soundEdited/consonants/pulmonics/V_alveolar_tap.wav',
                        'l': 'soundEdited/consonants/pulmonics/V_alveolar_lateral-approximant.wav',
                        'ç': 'soundEdited/consonants/pulmonics/VL_palatal_fricative.wav',
                        'ð': 'soundEdited/consonants/pulmonics/V_dental_fricative.wav',
                        'ʈ': 'soundEdited/consonants/pulmonics/VL_retroflex_plosive.wav',
                        'ɻ': 'soundEdited/consonants/pulmonics/V_retroflex_approximant.wav',
                        'ɟ': 'soundEdited/consonants/pulmonics/V_palatal_plosive.wav',
                        'p': 'soundEdited/consonants/pulmonics/VL_bilabial_plosive.wav',
                        'ʒ': 'soundEdited/consonants/pulmonics/V_postalveolar_fricative.wav',
                        'χ': 'soundEdited/consonants/pulmonics/VL_uvular_fricative.wav',
                        'f': 'soundEdited/consonants/pulmonics/VL_labiodental_fricative.wav',
                        'r': 'soundEdited/consonants/pulmonics/V_alveolar_trill.wav',
                        'ɱ': 'soundEdited/consonants/pulmonics/V_labiodental_nasal.wav',
                        'ŋ': 'soundEdited/consonants/pulmonics/V_velar_nasal.wav',
                        'n': 'soundEdited/consonants/pulmonics/V_alveolar_nasal.wav',
                        'β': 'soundEdited/consonants/pulmonics/V_bilabial_fricative.wav',
                        'ɹ': 'soundEdited/consonants/pulmonics/V_alveolar_approximant.wav',
                        'ʋ': 'soundEdited/consonants/pulmonics/V_labiodental_approximant.wav',
                        'ɸ': 'soundEdited/consonants/pulmonics/VL_bilabial_fricative.wav',
                        'j': 'soundEdited/consonants/pulmonics/V_palatal_approximant.wav',
                        'ɭ': 'soundEdited/consonants/pulmonics/V_retroflex_lateral-approximant.wav',
                        'v': 'soundEdited/consonants/pulmonics/V_labiodental_fricative.wav',
                        'ɲ': 'soundEdited/consonants/pulmonics/V_palatal_nasal.wav',
                        'ɽ': 'soundEdited/consonants/pulmonics/V_retroflex_tap.wav',
                        'x': 'soundEdited/consonants/pulmonics/VL_velar_fricative.wav',
                        'z': 'soundEdited/consonants/pulmonics/V_alveolar_fricative.wav',
                        's': 'soundEdited/consonants/pulmonics/VL_alveolar_fricative.wav',
                        'q': 'soundEdited/consonants/pulmonics/VL_uvular_plosive.wav',
                        'ⱱ': 'soundEdited/consonants/pulmonics/V_labialdental_flap.wav'}

        self.clickDict = {'ǁ': 'soundEdited/consonants/clicks/alveolar-lateral_click.wav',
                     'ǂ': 'soundEdited/consonants/clicks/palatoalveolar_click.wav',
                     'ǀ': 'soundEdited/consonants/clicks/dental_click.wav',
                     'ǃ': 'soundEdited/consonants/clicks/postalveolar_click.wav',
                     'ʘ': 'soundEdited/consonants/clicks/bilabial_click.wav'}

        self.ejectiveDict = {'kʼ': 'soundEdited/consonants/ejectives/VL_velar_ejective.wav',
                        'pʼ': 'soundEdited/consonants/ejectives/VL_bilabial_ejective.wav',
                        'tʼ': 'soundEdited/consonants/ejectives/VL_dental_ejective.wav',
                        'sʼ': 'soundEdited/consonants/ejectives/VL_alveolar-fricative_ejective.wav'}

        self.implosiveDict = {'ʛ': 'soundEdited/consonants/implosive/V_uvular_implosive.wav',
                         'ɠ': 'soundEdited/consonants/implosive/V_velar_implosive.wav',
                         'ʄ': 'soundEdited/consonants/implosive/V_palatal_implosive.wav',
                         'ɗ': 'soundEdited/consonants/implosive/V_dental_implosive.wav',
                         'ɓ': 'soundEdited/consonants/implosive/V_bilabial_implosive.wav'}

        self.otherDict = {'ʢ': 'soundEdited/consonants/others/V_epiglottal_fricative.wav',
                     'ɕ': 'soundEdited/consonants/others/VL_alveolo-palatal_fricative.wav',
                     'ɺ': 'soundEdited/consonants/others/V_alveolar_lateral_flap.wav',
                     'ɥ': 'soundEdited/consonants/others/V_labial-palatal_approximant.wav',
                     'ʍ': 'soundEdited/consonants/others/VL_labial-velar_fricative.wav',
                     'ʑ': 'soundEdited/consonants/others/V_alveolo-palatal_fricative.wav',
                     'ʜ': 'soundEdited/consonants/others/VL_epiglottal_fricative.wav'}

    @abstractmethod
    def addSounds(self, sounds):
        pass

    @abstractmethod
    def addRules(self, rs):
        pass





