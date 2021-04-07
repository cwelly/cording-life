using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class initialization : MonoBehaviour {
    [SerializeField] public Text water_inform;
    [SerializeField] public Text water_Text;

    // Use this for initialization
    void Start () {
        water_inform.enabled = false;
        water_Text.enabled = false;
	}
	

}
