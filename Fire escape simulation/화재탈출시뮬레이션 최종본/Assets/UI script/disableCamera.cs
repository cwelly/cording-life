using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class disableCamera : MonoBehaviour {

    public Camera thiscamera;

	// Use this for initialization
	void Start () {
        thiscamera.enabled = !thiscamera.enabled;
	}

}
