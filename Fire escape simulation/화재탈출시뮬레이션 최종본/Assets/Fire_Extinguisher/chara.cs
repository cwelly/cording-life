using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class chara : MonoBehaviour {
    Animator chaa;
	// Use this for initialization
	void Start () {
        chaa=GetComponent<Animator>();
	}
	
	// Update is called once per frame
	void Update () {
        if (Input.GetKeyDown(KeyCode.E))
            chaa.SetBool("nem", true);
    }
}
